package errorxcode.jitpack.expandablecard

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SimpleInfoCard (
    title: String,
    text: String,
    expended: Boolean = false,
    buttonTxt: String? = "View",
    onClick : (() -> Unit)? = { },
    cornerRadius: Int = 10
) {
    val expendedState = remember { mutableStateOf(expended) }
    Card(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Column(Modifier.padding(16.dp)) {
            CardHeader(title, expendedState)

            if (expendedState.value) {
                Text(text, Modifier.padding(0.dp, 5.dp))
                if (buttonTxt != null && onClick != null){
                    TextButton(onClick, Modifier.align(Alignment.End)) {
                        Text(buttonTxt)
                    }
                }
            }
        }
    }
}


@Composable
private fun ExpandableCard(title: String = "Hello world",expended: Boolean = false,content: @Composable () -> Unit = {}) {
    Card(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Column(Modifier.padding(16.dp)) {
            CardHeader("Card title", remember { mutableStateOf(expended) })
            content()
        }
    }
}

@Composable
private fun CardHeader(title: String, expended: MutableState<Boolean>) {
    val rotation by animateFloatAsState(if (expended.value) 180f else 0f, label = "")
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                expended.value = !expended.value
            }, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.weight(5f)
        )

        Image(
            imageVector = Icons.Default.ArrowDropDown, "",
            modifier = Modifier
                .weight(1f)
                .rotate(rotation))
    }
}

@Preview(showBackground = true)
@Composable
private fun Test() {
    Box {
//        ExpandableCard("This is title"){
//            SimpleInfoCard("This is title", "This is content")
//        }

        SimpleInfoCard("This is title", "This is content",true,"View",{
            println("View")
        })
    }
}
