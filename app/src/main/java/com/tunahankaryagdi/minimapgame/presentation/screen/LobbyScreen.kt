package com.tunahankaryagdi.minimapgame.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.tunahankaryagdi.minimapgame.R
import com.tunahankaryagdi.minimapgame.presentation.components.PrimaryButton
import java.util.Properties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LobbyScreen(
    modifier: Modifier = Modifier,
) {
    var isPopupVisible by remember{ mutableStateOf(false) }
    val clipboardManager = LocalClipboardManager.current

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "RoomName", fontWeight = FontWeight.Bold)
                },
                actions = {
                    Icon(
                        modifier = Modifier
                            .clickable { isPopupVisible = true },
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
            )
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
        ){

            if (isPopupVisible){
                InfoPopup(
                    onDismiss = {isPopupVisible = false},
                    onClickCopyToClipboard = {text->
                        clipboardManager.setText(AnnotatedString(text))
                    }
                )
            }
            LazyColumn(){
                items(10){
                    UserCard()
                    Divider()
                }
            }
            PrimaryButton(
                modifier = Modifier.align(Alignment.BottomCenter),
                onClick = { /*TODO*/ },
                textResId = R.string.start)
        }


    }
}

@Composable
private fun UserCard(
    modifier: Modifier = Modifier
) {

    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier
                .weight(1f)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(5.dp))
        
        Text(
            modifier = Modifier.weight(4f),
            text = "Armored Blade"
        )
    }
}

@Composable
fun InfoPopup(
    onDismiss:() -> Unit,
    onClickCopyToClipboard: (String) -> Unit
) {

    Popup(
        onDismissRequest = onDismiss,
        alignment = Alignment.TopEnd,
        properties = PopupProperties(
            dismissOnClickOutside = true,
            dismissOnBackPress = true
        )

    ){
        Row(
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(10))
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Column() {
                Text(
                    text = stringResource(id = R.string.room_id),
                    fontWeight = FontWeight.Bold
                )
                Text(text = "vkjdshvjkdshjvhdskjvds")
            }
            Icon(
                modifier = Modifier
                    .clickable {
                        onClickCopyToClipboard("vkjdshvjkdshjvhdskjvds")
                    },
                imageVector = Icons.Outlined.Build,
                contentDescription = null)
        }

    }

}