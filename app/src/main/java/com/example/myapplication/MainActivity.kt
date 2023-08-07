package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.TvShowList
import com.example.myapplication.model.TvShow
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         /*   Greeting{
                Toast.makeText(this,"$it",Toast.LENGTH_LONG).show()
            }*/
                DisplayTvShows{
                    //Toast.makeText(this,"$it",Toast.LENGTH_LONG).show()
                    startActivity(InfoActivity.intent(this,it))
                }
            }
        }

}

@Composable
fun Greeting(selectedItem: (String)-> (Unit)) {
   LazyColumn{
       items(100){
           Text(
               "Username $it",
               style = MaterialTheme.typography.headlineSmall,
               modifier = Modifier
                   .padding(10.dp)
                   .clickable { selectedItem("$it Selected") }
           )
           Divider(color = Color.Black, thickness = 5.dp)
       }
   }
}

@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit)
{
    val tvShows = remember{TvShowList.tvShows}

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    )
    {
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }
}
@Composable
fun TvShowListItem(tvShow: TvShow, selectedItem: (TvShow) -> Unit){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    )
    {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { selectedItem(tvShow) },
            verticalAlignment = Alignment.CenterVertically
        ){
            TvShowImage(tvShow = tvShow)
            Column{
                Text(text = tvShow.name,style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = tvShow.overview,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =  Arrangement.SpaceBetween
                )
                {
                    Text(
                        text = tvShow.year.toString(), style = MaterialTheme.typography.headlineMedium
                    )
                    Text (
                        text="${tvShow.rating}",style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun TvShowImage(tvShow: TvShow){
    Image(
        painter = painterResource(id = tvShow.imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(4.dp)
            .height(140.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
    )
}
