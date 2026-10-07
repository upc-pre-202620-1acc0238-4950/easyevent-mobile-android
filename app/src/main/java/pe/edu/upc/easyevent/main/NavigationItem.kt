package pe.edu.upc.easyevent.main

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import pe.edu.upc.easyevent.core.designsystems.favorite
import pe.edu.upc.easyevent.core.designsystems.home

enum class NavigationItem(
    val route: @Serializable Any,
    val icon: ImageVector,
    val title: String
) {
    HOME(
        HomeRoute,
        icon = home,
        title = "Home"
    ),
    FAVORITES(
        FavoritesRoute,
        icon = favorite,
        title = "Favorites"
    )

}