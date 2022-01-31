// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.awt.ComposePanel
import java.awt.BorderLayout
import javax.swing.JDialog
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

fun main() = SwingUtilities.invokeLater {
    val jFrameDialog = JDialog()
    jFrameDialog.defaultCloseOperation = WindowConstants.HIDE_ON_CLOSE //todo you can't use EXIT_ON_CLOSE
    jFrameDialog.title = "SwingComposeDialog"
    val composePanel = ComposePanel()
    jFrameDialog.contentPane.add(composePanel, BorderLayout.CENTER)
    composePanel.setContent {
        Column {
            Text("composePanel setContent")
            Button(onClick = {
//                jFrameWindow.moveToTray(true)
            }) {
                Text("hide window to tray")
            }
            Button(onClick = {
//                jFrameWindow.moveToTray(false)
            }) {
                Text("move to tray, but don't hide window")
            }
        }
    }
    jFrameDialog.setSize(800, 600)
    jFrameDialog.isVisible = true
}
