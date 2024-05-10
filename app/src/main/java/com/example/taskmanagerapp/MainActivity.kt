package com.example.taskmanagerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagerapp.ui.theme.TaskManagerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface( modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background)
                    {

                        TaskManager(
                            taskStatus = stringResource(R.string.task_status_text),
                            remarks = stringResource(R.string.remarks_text)
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun TaskManagerText(taskStatus: String, remarks: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 250.dp)) {
        Text(
            text = taskStatus,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
        )
        Text(
            text = remarks,
            fontSize = 16.sp
        )
    }

}

@Composable
fun TaskManager(taskStatus: String, remarks: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed);

    Box(modifier = Modifier,
        contentAlignment = Alignment.Center
        ){
        Image(
            painter = image,
            contentDescription = null )
        TaskManagerText(
            taskStatus = taskStatus ,
            remarks = remarks,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
         }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TaskManagerAppTheme {
        TaskManager(
            taskStatus = stringResource(R.string.task_status_text),
            remarks = stringResource(R.string.remarks_text)
        )
    }
}