package com.example.foodfor_kmm.android.presentation.components

import androidx.compose.runtime.Composable
import com.example.foodfor_kmm.android.presentation.theme.onDismissType
import com.example.foodfor_kmm.common.utils.GenericMessageInfo
import com.example.foodfor_kmm.common.utils.Queue

@Composable
fun ProcessDialogQueue(
    dialogQueue: Queue<GenericMessageInfo>,
    onRemoveHeadFromQueue: () -> Unit,
) {
    dialogQueue.peek()?.let { dialogInfo ->
        GenericDialog(
            onDismiss = dialogInfo.onDismiss,
            title = dialogInfo.title,
            description = dialogInfo.description,
            positiveAction = dialogInfo.positiveAction,
            negativeAction = dialogInfo.negativeAction
        ) {
            onRemoveHeadFromQueue()
        }
    }
}