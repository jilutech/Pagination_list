package com.example.pagination.ux
import androidx.compose.foundation.clickable
import com.example.pagination.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.unit.dp
import com.example.pagination.data.network.User
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.paging.compose.items

@Composable
fun UserList(viewModel: MainViewModel){
    val usersList = viewModel.usersPager.collectAsLazyPagingItems()

    LazyColumn{
        items(usersList){ item ->
            item?.let { 
                UserCard(user = item)
            }
        }


    }
}

@Composable
fun UserCard(user: User){
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .wrapContentHeight()
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(user.picture).crossfade(true)
                .build(), placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(coil.compose.base.R.string.default_error_message),
            contentScale = ContentScale.Crop, modifier = Modifier
                    .clip(CircleShape)
                    .width(42.dp)
                    .height(42.dp))
            
            Text(text = user.name,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(CenterVertically))
        }

    }
}

@Preview
@Composable
fun UserPreview(){
    UserCard(user = User("jilu","12","jose","","mr"))
}