package com.tunahankaryagdi.minimapgame.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tunahankaryagdi.minimapgame.R
import com.tunahankaryagdi.minimapgame.presentation.components.PrimaryButton

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
) {

    var isVisibleJoinRoomSection by remember { mutableStateOf(false) }
    var isVisibleCreateRoomSection by remember { mutableStateOf(false) }
    var roomId by remember { mutableStateOf("") }
    var roomName by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        PrimaryButton(
            onClick = { isVisibleJoinRoomSection = !isVisibleJoinRoomSection },
            textResId = R.string.join_room
        )

        if (isVisibleJoinRoomSection){
            Spacer(modifier = Modifier.height(5.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                TextField(
                    value = roomId,
                    onValueChange = {roomId = it},
                    placeholder = {
                        Text(text = stringResource(id = R.string.enter_the_room_id))
                    }
                )
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                        contentDescription = null
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        PrimaryButton(
            onClick = { isVisibleCreateRoomSection = !isVisibleCreateRoomSection },
            textResId = R.string.create_room
        )

        if (isVisibleCreateRoomSection){
            Spacer(modifier = Modifier.height(5.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                TextField(
                    value = roomName,
                    onValueChange = {roomName = it},
                    placeholder = {
                        Text(text = stringResource(id = R.string.enter_the_room_name))
                    }
                )


                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                        contentDescription = null
                    )
                }
            }
        }
    }
}