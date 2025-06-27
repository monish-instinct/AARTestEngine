package skynetbee.developers.developerenvironment

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Smart Button component with enhanced styling and functionality
 * Part of the SkynetBee Developer Environment Library
 */
object SmartButton {
    
    enum class Style {
        PRIMARY,
        SECONDARY,
        SUCCESS,
        WARNING,
        DANGER
    }
    
    /**
     * Create a Smart Button with enhanced styling
     * 
     * @param text Button text
     * @param onClick Click handler
     * @param style Button style (PRIMARY, SECONDARY, etc.)
     * @param modifier Compose modifier
     * @param enabled Whether button is enabled
     * @param fullWidth Whether button should take full width
     */
    @Composable
    fun Create(
        text: String,
        onClick: () -> Unit,
        style: Style = Style.PRIMARY,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        fullWidth: Boolean = false
    ) {
        val colors = when (style) {
            Style.PRIMARY -> ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1976D2),
                contentColor = Color.White
            )
            Style.SECONDARY -> ButtonDefaults.buttonColors(
                containerColor = Color(0xFF757575),
                contentColor = Color.White
            )
            Style.SUCCESS -> ButtonDefaults.buttonColors(
                containerColor = Color(0xFF388E3C),
                contentColor = Color.White
            )
            Style.WARNING -> ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF57C00),
                contentColor = Color.White
            )
            Style.DANGER -> ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD32F2F),
                contentColor = Color.White
            )
        }
        
        Button(
            onClick = onClick,
            colors = colors,
            enabled = enabled,
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
            modifier = modifier
                .then(if (fullWidth) Modifier.fillMaxWidth() else Modifier)
                .height(48.dp)
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
