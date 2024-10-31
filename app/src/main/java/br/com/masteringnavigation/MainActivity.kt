package br.com.masteringnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.masteringnavigation.ui.theme.MasteringNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MasteringNavigationTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable(route = "home") {
                        HomeScreen(
                            onDetailsClick = {
                                title -> navController.navigate("details/$title")
                            },
                            onAboutClick = {
                                navController.navigate("about")
                            }
                        )
                    }

                    composable("about") {
                        AboutScreen( onNavigateUp = {
                            navController.popBackStack()
                        })
                    }

                    composable("details/{title}",
                        arguments = listOf(navArgument("title"){
                            type= NavType.StringType
                            nullable = true
                        })
                        ) {

                        backStackEntry ->
                            val arguments = requireNotNull(backStackEntry.arguments)

                        val title = arguments.getString("title")
                        if (title != null) {
                            DetailsScreen(title = title, onNavigateUp = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    onDetailsClick: (title:String) -> Unit,
    onAboutClick: () -> Unit
) {
    Scaffold { padding ->
        LazyColumn(contentPadding = padding) {
            item {
                HomeAppBar(onAboutClick)
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
            items(allCourses) {
                item -> CourseCard(item, onClick = {
                    onDetailsClick(item.title)
            })
            }
        }
    }
}

@Composable
private fun HomeAppBar(onAboutClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text("My Udemy courses", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = onAboutClick) {
            Text("About", fontSize = 24.sp)
        }
    }
}

@Composable
fun CourseCard(item: Courses, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Column {
            Image(
                painter = painterResource(id = item.thumbnail),
                contentDescription = "Thumb",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(text = item.title)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.body, maxLines = 2, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun AboutScreen(onNavigateUp: () -> Unit) {
    Scaffold { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            AppBar(title = "About", onNavigateUp)
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("This app is a demonstration about the navigation" +
                "In android jetpack compose")
                Spacer(modifier = Modifier.height(20.dp))

                val udemyLink = LocalUriHandler.current
                Button(onClick = {
                    udemyLink.openUri("https://www.udemy.com/course/mastering-jetpack-compose/learn/lecture/38145166#overview")
                }) {
                    Text("View our Udemy Course")
                }
            }
        }
    }
}

@Composable
fun AppBar(title: String, onNavigateUp: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        IconButton(onClick = onNavigateUp) {
            Icon(Icons.Rounded.ArrowBack, contentDescription = "Back icon")
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(text = title, fontSize = 24.sp)
    }
}

@Composable
fun DetailsScreen(title: String, onNavigateUp: () -> Unit) {

    val choosen_course = allCourses.first{it.title == title}

    Scaffold { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            IconButton(onClick = onNavigateUp) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "Back button")
            }

            Image(painter = painterResource(
                id = choosen_course.thumbnail),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))
            
            Column {
                Text(text = choosen_course.title, fontSize = 40.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = choosen_course.body, modifier = Modifier.fillMaxSize(), fontSize = 20.sp)
            }
        }
    }
}