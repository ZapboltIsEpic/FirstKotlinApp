import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

data class Task(val task : String, val completed : Boolean)

@Composable
fun TaskCard(task: Task, onTaskCompletionChanged: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = task.task)
        Checkbox(
            checked = task.completed,
            onCheckedChange = onTaskCompletionChanged
        )
    }
}

@Composable
fun TaskList() {
    // Create a state to hold the task
    var task by remember { mutableStateOf(Task(task = "Do laundry", completed = false)) }

    // Display the TaskCard
    TaskCard(
        task = task,
        onTaskCompletionChanged = { isChecked ->
            task = task.copy(completed = isChecked)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskList() {
    TaskList()
}

@Composable
fun addTask(task : Task) {

}