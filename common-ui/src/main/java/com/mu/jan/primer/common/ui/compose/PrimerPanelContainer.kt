package com.mu.jan.primer.common.ui.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlin.math.roundToInt

enum class DrawerTypes {
    LEFT, RIGHT
}

enum class CenterScreenState {
    LEFT_ANCHORED, CENTER, RIGHT_ANCHORED
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PrimerPanelContainer(
    sidePanel: @Composable () -> Unit,
    leftPanel: @Composable () -> Unit,
    centerPanel: @Composable () -> Unit,
) {
    Surface {
        val density = LocalDensity.current
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp

        val screenCenterDp by remember(screenWidth) {
            mutableStateOf(
                screenWidth.times(
                    0.5f
                )
            )
        }

        val rightEndpointDp by remember(screenWidth) {
            mutableStateOf(
                screenWidth.times(
                    1.4f
                )
            )
        }

        val screenCenterPx by remember(screenCenterDp) {
            mutableStateOf(with(density) { screenCenterDp.toPx() })
        }

        val rightEndpointPx by remember(rightEndpointDp) {
            mutableStateOf(with(density) { rightEndpointDp.toPx() })
        }

        val rightSwipeableState =
            rememberSwipeableState(initialValue = CenterScreenState.RIGHT_ANCHORED)

        val rightAnchors = mapOf(
            screenCenterPx to CenterScreenState.CENTER,
            rightEndpointPx to CenterScreenState.RIGHT_ANCHORED
        )

        val rightDrawerOnTop by remember {
            derivedStateOf {
                when (rightSwipeableState.currentValue) {
                    CenterScreenState.LEFT_ANCHORED -> DrawerTypes.RIGHT
                    CenterScreenState.CENTER -> {
                        if (rightSwipeableState.direction < 0) DrawerTypes.RIGHT
                        else DrawerTypes.LEFT
                    }
                    CenterScreenState.RIGHT_ANCHORED -> DrawerTypes.LEFT
                }
            }
        }

        val isAnyItemSelectedInServers: Boolean by remember { mutableStateOf(true) }

        val rightSwipeableModifier by remember(isAnyItemSelectedInServers) {
            mutableStateOf(
                if (isAnyItemSelectedInServers) {
                    Modifier.swipeable(
                        state = rightSwipeableState,
                        anchors = rightAnchors,
                        thresholds = { _, _ -> FractionalThreshold(0.5f) },
                        orientation = Orientation.Horizontal
                    )
                } else {
                    Modifier
                }
            )
        }

        val leftDrawerModifier by remember(rightDrawerOnTop, isAnyItemSelectedInServers) {
            mutableStateOf(
                rightSwipeableModifier
                    .zIndex(0f)
                    .alpha(if (rightDrawerOnTop == DrawerTypes.LEFT) 1f else 0f)
            )
        }

        val centerScreenOffset by remember {
            derivedStateOf {
                if (rightDrawerOnTop == DrawerTypes.LEFT) {
                    (rightSwipeableState.offset.value - screenCenterPx).roundToInt()
                } else {
                    0
                }
            }
        }

        val centerScreenPadding by remember(
            rightSwipeableState.isAnimationRunning,
            rightSwipeableState.currentValue,
            rightSwipeableState.progress.fraction
        ) {
            mutableStateOf(if (rightSwipeableState.isAnimationRunning || rightSwipeableState.currentValue == CenterScreenState.CENTER || rightSwipeableState.progress.fraction in 0.05f..0.95f) 0.dp else 20.dp)
        }

        val screenPadding by remember {
            mutableStateOf(20.dp)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.05f),
                ),
        ) {
            // Left Panel + Side Panel
            Surface(
                modifier = leftDrawerModifier
                    .align(Alignment.CenterStart)
                    .fillMaxHeight()
                    .fillMaxWidth(0.87f)
                    .padding(top = screenPadding)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.3f)
                            .background(color = MaterialTheme.colors.onBackground.copy(alpha = 0.05f))
                    ) {
                        sidePanel.invoke()
                    }
                    Card(
                        elevation = 1.5.dp,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(1f)
                            .background(
                                color = MaterialTheme.colors.background,
                                shape = MaterialTheme.shapes.medium.copy(
                                    topStart = CornerSize(screenPadding),
                                    topEnd = CornerSize(screenPadding),
                                    bottomEnd = CornerSize(0.dp),
                                    bottomStart = CornerSize(0.dp)
                                )
                            )
                    ) {
                        leftPanel.invoke()
                    }
                }
            }

            // Center Panel
            val centerScreenZIndex by remember {
                derivedStateOf {
                    if (rightSwipeableState.isAnimationRunning || rightSwipeableState.currentValue == CenterScreenState.CENTER || rightSwipeableState.progress.fraction in 0.05f..0.95f) 1f
                    else 0.5f
                }
            }
            AnimatedVisibility(
                modifier = rightSwipeableModifier
                    .zIndex(centerScreenZIndex)
                    .offset { IntOffset(x = centerScreenOffset, y = 0) },
                visible = isAnyItemSelectedInServers,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Card(
                    elevation = 5.dp,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = centerScreenPadding)
                        .background(
                            color = MaterialTheme.colors.background,
                            shape = MaterialTheme.shapes.medium.copy(
                                topStart = CornerSize(centerScreenPadding),
                                topEnd = CornerSize(centerScreenPadding),
                                bottomEnd = CornerSize(0.dp),
                                bottomStart = CornerSize(0.dp)
                            )
                        )
                ) {
                    centerPanel.invoke()
                }
            }
        }
    }
}