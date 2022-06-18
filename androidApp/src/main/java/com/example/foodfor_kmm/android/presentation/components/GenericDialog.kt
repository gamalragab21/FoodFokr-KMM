package com.example.foodfor_kmm.android.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodfor_kmm.common.utils.NegativeAction
import com.example.foodfor_kmm.common.utils.PositiveAction

@Composable
fun GenericDialog(
    modifier: Modifier = Modifier,
    onDismiss: (() -> Unit)?,
    title: String,
    description: String? = null,
    positiveAction: PositiveAction?,
    negativeAction: NegativeAction?,
    onRemoveHeadFromQueue: () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onDismiss?.invoke()
            onRemoveHeadFromQueue()
        },
        text = {
            if (description != null) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.body1
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h3
            )
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
                    onClick = {
                        negativeAction?.onNegativeAction?.let {
                            it()
                        }
                        onRemoveHeadFromQueue()
                    }
                ) {
                    Text(text = negativeAction?.negativeBtnTxt ?: "Cancel")
                }
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {
                        positiveAction?.onPositiveAction?.let {
                            it()
                        }
                        onRemoveHeadFromQueue()
                    }
                ) {
                    Text(text = positiveAction?.positiveBtnTxt ?: "OK")
                }
            }
        }
    )
}