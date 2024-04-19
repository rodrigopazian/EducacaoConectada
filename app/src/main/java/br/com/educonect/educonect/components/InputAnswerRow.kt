package br.com.educonect.educonect.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.educonect.educonect.R

@Composable
fun InputAnswerRow(
    valueIar: String,
    txtInputChangeIar: (String) -> Unit,
    txtAltIar: String,
    btnClearonClickIar: () -> Unit,
    spacerBottIar: Int,
    isSelected: Boolean,
    onOptionSelected: () -> Unit
) {
    //Start - Component Row
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        RadioButton(
            selected = isSelected,
            onClick = onOptionSelected

        )

        //Start - Component Text Field
        Text(
            modifier = Modifier
                .size(34.dp),
            textAlign = TextAlign.Center,
            text = txtAltIar,
            color = Color.White,
            //font with scale adaptable to the user preferences
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        //End - Component Text Field

        //Start - Component Input Text Field
        InputTextField(
            valueItf = valueIar,
            textstyleItf = TextStyle(color = Color.White, fontSize = 12.sp),
            placehItf =  stringResource(id = R.string.view_i_exerc_ph_alt_a),
            placeHminHeightItf = 40,
            placeHModifier = Modifier.defaultMinSize(minWidth = 200.dp),
            keyboardTypeItf = KeyboardType.Ascii,
            modifierItf = Modifier
                .wrapContentSize()
                .widthIn(min = 250.dp, max = 250.dp),

            txtInputChangeItf = txtInputChangeIar,
            spacerTop = 5,
            spacerBott = 5,
        )
        //End - Component Input Text Field

        Button(
            modifier = Modifier
                .wrapContentSize()
                .offset(x = (-12).dp, y = (-4).dp),
            shape = RectangleShape,
            onClick = btnClearonClickIar,
            border = BorderStroke(2.dp, Color.Transparent),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x00FFFFFF)),

            ) {
            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Limpar texto"
            )
        }

    }
//End - Component Row
    Spacer(modifier = Modifier.height(spacerBottIar.dp))

}