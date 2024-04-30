package br.com.educonect.educonect.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.educonect.educonect.R

@Composable
fun InputTextField(
    valueItf: String,
    placehItf: String,
    placeHminHeightItf: Int,
    placeHModifier: Modifier,
    keyboardTypeItf: KeyboardType,
    modifierItf: Modifier,
    textstyleItf: TextStyle,
    txtInputChangeItf: (String) -> Unit,
    spacerTop: Int,
    spacerBott: Int,
) {
    Spacer(modifier = Modifier.height(spacerTop.dp))

    OutlinedTextField(
        value = valueItf,
        textStyle = textstyleItf,
        onValueChange = txtInputChangeItf,
        placeholder = {
            Row (
                modifier = Modifier.defaultMinSize(minHeight = placeHminHeightItf.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = placeHModifier,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    //font with scale adaptable to the user preferences
                    text = placehItf
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardTypeItf
        ),
        modifier = modifierItf.border(2.dp, color = colorResource(id = R.color.purple_200)),


    )

    Spacer(modifier = Modifier.height(spacerBott.dp))
}