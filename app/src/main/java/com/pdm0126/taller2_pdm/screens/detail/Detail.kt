package com.pdm0126.taller2_pdm.screens.detail

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pdm0126.taller2_pdm.model.Dish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(viewModel: DetailViewModel, onBack: () -> Unit) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(uiState.restaurant?.name ?: "Detalle", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { pad ->
        val restaurant = uiState.restaurant
        when {
            uiState.isLoading -> Box(Modifier.fillMaxSize().padding(pad),
                Alignment.Center) { CircularProgressIndicator() }
            restaurant == null -> Box(Modifier.fillMaxSize().padding(pad),
                Alignment.Center) { Text("No encontrado") }
            else -> {
                LazyColumn(Modifier.fillMaxSize().padding(pad)) {
                    item {
                        AsyncImage(
                            model = restaurant.imageUrl,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth().height(200.dp)
                        )
                        Column(Modifier.padding(16.dp)) {
                            Text(restaurant.name, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                            Text(restaurant.description, style = MaterialTheme.typography.bodyMedium)
                            Spacer(Modifier.height(16.dp))
                            Text("Nuestro Menú", style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary)
                            HorizontalDivider(Modifier.padding(vertical = 8.dp))
                        }
                    }
                    items(restaurant.menu) { dish ->
                        DishItem(dish) {
                            Toast.makeText(context, "${dish.name} añadido", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DishItem(dish: Dish, onAdd: () -> Unit) {
    Card(
        Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = dish.imageUrl,
                contentDescription = null,
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.weight(1f).padding(start = 12.dp)) {
                Text(dish.name, fontWeight = FontWeight.Bold)
                Text(dish.description, style = MaterialTheme.typography.bodySmall)
                Button(onClick = onAdd, Modifier.align(Alignment.End)) {
                    Text("+ Agregar", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}