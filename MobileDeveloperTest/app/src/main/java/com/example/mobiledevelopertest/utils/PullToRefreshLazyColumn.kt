package com.example.mobiledevelopertest.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun <T> PullToRefreshLazyColum(
//    items: List<T>,
//    content: @Composable (T) -> Unit,
//    isRefreshing: Boolean,
//    onRefresh: () -> Unit,
//    modifier: Modifier = Modifier,
//    lazyListState: LazyListState = rememberLazyListState(),
//) {
//
//    val pullToRefreshState = rememberPullToRefreshState()
//    Box(modifier = modifier.nestedScroll(pullToRefreshState.nestedScrollConnection)) {
//        LazyColumn(
//            state = lazyListState,
//            modifier = Modifier.fillMaxSize(),
//        ) {
//            items(items) {
//                content(it)
//            }
//
//        }
//
//        if(pullToRefreshState.isAnimating){
//            LaunchedEffect(pullToRefreshState.isAnimating) {
//                onRefresh()
//            }
//        }
//
//        LaunchedEffect(isRefreshing) {
//            if(isRefreshing){
//                pullToRefreshState.startRefresh()
//            }else{
//                pullToRefreshState.endRefresh()
//            }
//        }
//
//        PullToRefreshContainer(
//            state = pullToRefreshState,
//            modifier = Modifier.align(Alignment.TopCenter)
//        )
//    }
//
//}