package com.example.a7daysofselfcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a7daysofselfcare.data.Datasource
import com.example.a7daysofselfcare.model.Tip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        AppTitle()
                        TipList(tipList = Datasource().taskList)
                    }

                }
            }
        }
    }
}
@Composable
fun AppTitle(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 36.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun TipCard(tip: Tip, modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }

    Card(modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp).clickable { expanded = !expanded }) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = stringResource(id = tip.day),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 12.dp)
            )
            Text(
                text = stringResource(id = tip.tip),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 12.dp)
            )
            Image(
                painter = painterResource(id = tip.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(150.dp)
            )
            if (expanded) {
                Text(
                    text = stringResource(id = tip.desc),
                    modifier = Modifier.padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 12.dp))
            }
        }
    }
}

@Composable
fun TipList(tipList: List<Tip>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(tipList) {tip ->
            TipCard(tip = tip)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Column {
            AppTitle()
            TipList(tipList = Datasource().taskList)
        }

    }
}