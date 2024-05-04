package com.tunahankaryagdi.minimapgame.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    modifier: Modifier = Modifier
) {
    val konya = LatLng(37.874641, 32.493156)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(konya, 10f)
    }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    )
}