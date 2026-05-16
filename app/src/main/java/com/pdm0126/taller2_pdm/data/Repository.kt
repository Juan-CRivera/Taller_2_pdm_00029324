package com.pdm0126.taller2_pdm.data

import com.pdm0126.taller2_pdm.model.Dish
import com.pdm0126.taller2_pdm.model.Restaurant

interface RestaurantRepository {
    fun getAllRestaurants(): List<Restaurant>
    fun getRestaurantById(id: Int): Restaurant?
    fun searchRestaurants(query: String): List<Restaurant>
}

class Repository: RestaurantRepository {

    private val restaurants = listOf(
        // ─── Comida Rápida ────────────────────────────────────────────────────
        Restaurant(
            id = 1,
            name = "Wendys",
            description = "Las hamburguesas más jugosas de la ciudad, hechas con ingredientes frescos.",
            imageUrl = "https://upload.wikimedia.org/wikipedia/en/3/32/Wendy%27s_full_logo_2012.svg",
            categories = listOf("Comida Rápida"),
            menu = listOf(
                Dish(
                    1,
                    "Dave Single",
                    "Carne de res, lechuga, tomate y queso cheddar",
                    "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?q=80&w=600"
                ),
                Dish(
                    2,
                    "Bacon Jr.",
                    "Tocino crujiente y queso derretido",
                    "https://images.unsplash.com/photo-1553979459-d2229ba7433b?q=80&w=600"
                ),
                Dish(
                    3,
                    "Veggie Burger",
                    "Hamburguesa de lechuga,tomate y carne vegana",
                    "https://images.unsplash.com/photo-1520072959219-c595dc870360?q=80&w=600"
                ),
                Dish(
                    4,
                    "Papas Fritas",
                    "Crujientes por fuera, suaves por dentro, con sal",
                    "https://images.unsplash.com/photo-1573080496219-bb080dd4f877?q=80&w=600"
                )
            )
        ),
        Restaurant(
            id = 2,
            name = "Don Pollo",
            description = "Pollo a la brasa con marinados especiales y acompañamientos caseros.",
            imageUrl = "https://www.donpollo.com.sv/images/logo.png",
            categories = listOf("Comida Rápida"),
            menu = listOf(
                Dish(5, "Piezas de pollo", "Pollo entero frito por piezas", "https://images.unsplash.com/photo-1598514982901-c28d684f30e4?q=80&w=600"),
                Dish(6, "Nuggets", "Medallones de pollo frito crujientes", "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?q=80&w=600"),
                Dish(7, "Alitas", "Alitas bañadas en salsa BBQ ", "https://images.unsplash.com/photo-1527477396000-e27163b481c2?q=80&w=600")
            )
        ),
        Restaurant(
            id = 3,
            name = "La Cantinflada",
            description = "Auténticos tacos mexicanos con recetas tradicionales y tortillas hechas a mano.",
            imageUrl = "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?q=80&w=900",
            categories = listOf("Comida Rápida", "Mexicana"),
            menu = listOf(
                Dish(8, "Taco al Pastor", "Cerdo adobado con piña, cilantro y cebolla", "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?q=80&w=600"),
                Dish(9, "Tacos de canasta", "8 de res con queso fundido y cebolla", "https://images.unsplash.com/photo-1640472769098-e1509a6f8e22?q=80&w=600"),
                Dish(10, "Quesadilla", "Tortilla de maíz con queso derretido y rajas poblanas", "https://images.unsplash.com/photo-1618040996337-56904b7850b9?q=80&w=600")
            )
        ),

        // ─── Italiana ─────────────────────────────────────────────────────────
        Restaurant(
            id = 4,
            name = "Dominos Pizza",
            description = "Las mejores pizzas artesanales de la ciudad, con ingredientes frescos importados.",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/7/74/Dominos_pizza_logo.svg",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(11, "Pizza Hongo", "Mozzarella, salsa de tomate y hongos frescos ", "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=600"),
                Dish(12, "Pizza Pepperoni", "Pepperoni, mozzarella y salsa picante opcional", "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?q=80&w=600"),
                Dish(13, "Pizza Cuatro Quesos", "Mozzarella, parmesano, gorgonzola y ricotta", "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=600"),
                Dish(14, "Pizza Hawaiana", "Jamón, piña, mozzarella y salsa de tomate", "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=600")
            )
        ),
        Restaurant(
            id = 5,
            name = "Pastaria",
            description = "Pasta fresca elaborada a diario con harinas italianas y salsas de receta familiar.",
            imageUrl = "https://images.unsplash.com/photo-1555949258-eb67b1ef0ceb?q=80&w=900",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(15, "Spaghetti Carbonara", "Pasta con huevo, panceta, parmesano y pimienta negra", "https://images.unsplash.com/photo-1612874742237-6526221588e3?q=80&w=600"),
                Dish(16, "Fettuccine Alfredo", "Pasta con crema, mantequilla y queso parmesano", "https://images.unsplash.com/photo-1555949258-eb67b1ef0ceb?q=80&w=600"),
                Dish(17, "Lasagna Boloñesa", "Capas de pasta, carne molida, bechamel y mozzarella", "https://images.unsplash.com/photo-1560781290-7dc94c0f8f4f?q=80&w=600")
            )
        ),

        // ─── Asiática ─────────────────────────────────────────────────────────
        Restaurant(
            id = 6,
            name = "Sushi King",
            description = "Sushi fresco preparado por chefs japoneses con pescado traído directamente del mar.",
            imageUrl = "https://sushiking.com.sv/wp-content/uploads/2021/04/Logo-Sushi-King.png",
            categories = listOf("Asiática", "Japonesa"),
            menu = listOf(
                Dish(18, "Roll California", "Cangrejo, aguacate y pepino con ajonjolí", "https://images.unsplash.com/photo-1617196034183-421b4040ed20?q=80&w=600"),
                Dish(19, "Nigiri de Salmón", "Arroz de sushi con lámina de salmón fresco", "https://images.unsplash.com/photo-1579584425555-c3ce17fd4351?q=80&w=600"),
                Dish(20, "Ramen Tonkotsu", "Caldo de cerdo, noodles, huevo marinado y nori", "https://images.unsplash.com/photo-1569050467447-ce54b3bbc37d?q=80&w=600"),
                Dish(21, "Edamame", "Vainas de soya al vapor con sal marina", "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?q=80&w=600")
            )
        ),
        Restaurant(
            id = 7,
            name = "China Wok",
            description = "Cocina asiática de wok rápida y llena de sabor, con ingredientes frescos salteados al momento.",
            imageUrl = "https://www.chinawok.com.sv/wp-content/uploads/2020/09/logo-chinawok.png",
            categories = listOf("Asiática", "China"),
            menu = listOf(
                Dish(22, "Arroz Frito Especial", "Arroz, pollo, camarón, huevo y vegetales salteados", "https://images.unsplash.com/photo-1512058564366-18510be2db19?q=80&w=600"),
                Dish(23, "Chow Mein de Res", "Noodles salteados con tiras de res y verduras", "https://images.unsplash.com/photo-1534482421-64566f976cfa?q=80&w=600"),
                Dish(24, "Dim Sum Surtido", "Selección de 6 dumplings al vapor con salsa de soya", "https://images.unsplash.com/photo-1563245372-f21724e3856d?q=80&w=600")
            )
        ),

        // ─── Saludable ────────────────────────────────────────────────────────
        Restaurant(
            id = 8,
            name = "Go Green",
            description = "Bowls nutritivos y ensaladas frescas para quienes cuidan su alimentación sin sacrificar el sabor.",
            imageUrl = "https://gogreen.com.sv/wp-content/uploads/2023/05/logo-gogreen.png",
            categories = listOf("Saludable"),
            menu = listOf(
                Dish(25, "Buddha Bowl", "Quinoa, garbanzos, aguacate, zanahoria y tahini", "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?q=80&w=600"),
                Dish(26, "Ensalada César", "Lechuga romana, pollo grillado, crutones y aderezo césar", "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?q=80&w=600"),
                Dish(27, "Smoothie Bowl", "Base de açaí, banana, granola y frutas frescas", "https://images.unsplash.com/photo-1490323914169-4b2bb83c4539?q=80&w=600"),
                Dish(28, "Wrap Vegano", "Tortilla integral, hummus, espinaca, tomate y pepino", "https://images.unsplash.com/photo-1628191013085-990d39e61a42?q=80&w=600")
            )
        ),
        Restaurant(
            id = 9,
            name = "Olive Garden",
            description = "Comida balanceada con macros calculados, ideal para deportistas y personas activas.",
            imageUrl = "https://upload.wikimedia.org/wikipedia/en/e/e0/Olive_Garden_Logo.svg",
            categories = listOf("Saludable"),
            menu = listOf(
                Dish(29, "Pollo con Brócoli", "Pechuga de pollo al vapor con brócoli y arroz integral", "https://images.unsplash.com/photo-1598515214211-89d3c73ae83b?q=80&w=600"),
                Dish(30, "Salmón al Horno", "Filete de salmón con espárragos y batata asada", "https://images.unsplash.com/photo-1467003909585-2f8a72700288?q=80&w=600"),
                Dish(31, "Overnight Oats", "Avena, chía, leche de almendras, frutos rojos y miel", "https://images.unsplash.com/photo-1517673408785-4bdb88a0f58e?q=80&w=600")
            )
        ),

        // ─── Postres ──────────────────────────────────────────────────────────
        Restaurant(
            id = 10,
            name = "Crepe Lovers",
            description = "Postres artesanales elaborados con chocolate belga y frutas de temporada.",
            imageUrl = "https://crepelovers.com/wp-content/uploads/2021/11/logo-crepe-lovers.png",
            categories = listOf("Postres"),
            menu = listOf(
                Dish(32, "Crepas de nutella", "Crepas hechas con nutella, banana y fresa.", "https://images.unsplash.com/photo-1533134242443-d4fd215305ad?q=80&w=600"),
                Dish(33, "Brownie con Helado", "Brownie de chocolate caliente con helado de vainilla", "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?q=80&w=600"),
                Dish(34, "Tiramisú", "Bizcochos, mascarpone, café espresso y cacao en polvo", "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?q=80&w=600"),
                Dish(35, "Waffle con Nutella", "Waffle belga crujiente con Nutella y frutos rojos frescos", "https://images.unsplash.com/photo-1562376552-0d160a2f238d?q=80&w=600")
            )
        ),
    )

    override fun getAllRestaurants(): List<Restaurant> = restaurants

    override fun getRestaurantById(id: Int): Restaurant? =
        restaurants.find { it.id == id }

    override fun searchRestaurants(query: String): List<Restaurant> {
        if (query.isBlank()) return emptyList()
        val q = query.trim().lowercase()
        return restaurants.filter { restaurant ->
            restaurant.name.lowercase().contains(q) ||
                    restaurant.menu.any { dish -> dish.name.lowercase().contains(q) }
        }
    }
}