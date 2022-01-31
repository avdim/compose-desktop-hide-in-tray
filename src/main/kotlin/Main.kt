// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.awt.ComposePanel
import java.awt.BorderLayout
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() = SwingUtilities.invokeLater {
    val window = HideToSystemTray() // or simple JFrame()
    val composePanel = ComposePanel()
    window.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    window.title = "SwingComposeWindow"
    window.contentPane.add(composePanel, BorderLayout.CENTER)
    composePanel.setContent {
        Column {
            Text("composePanel setContent")
            Button(onClick = {
                window.moveToTray(true)
            }) {
                Text("hide window to tray")
            }
            Button(onClick = {
                window.moveToTray(false)
            }) {
                Text("move to tray, but don't hide window")
            }
        }
    }
    window.setSize(800, 600)
    window.isVisible = true
}
