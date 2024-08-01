package com.example.galleryapp.features.component

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SnackBar(
    snackbarHostState: SnackbarHostState,
    snackBarEnum: SnackBarEnum
) {
    SnackbarHost(snackbarHostState) { data ->
        Snackbar(
            elevation = 0.dp,
            backgroundColor = Color(integerResource(id = snackBarEnum.backgroundColor)),
            snackbarData = data,
            shape = MaterialTheme.shapes.medium
        )
    }
}

sealed class SnackBarEnum(val backgroundColor: Int) {
    //TODO("Add your own SnackBarEnum")
    object SUCCESS : SnackBarEnum(com.example.galleryapp.R.color.black)
    object ERROR : SnackBarEnum(com.example.galleryapp.R.color.black)
}

@Preview
@Composable
private fun BodyPreview() {
    SnackBar(
        rememberScaffoldState().snackbarHostState,
        SnackBarEnum.SUCCESS
    )
}