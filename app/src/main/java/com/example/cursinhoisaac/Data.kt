package com.example.cursinhoisaac

// Classe para representar os dados dos gráficos
data class GraficoData(
    val titulo: String,
    val texto: String,
    val arquivoJson: String // Adicionamos o nome do arquivo JSON
)

// Lista com os dados dos gráficos
val graficos = listOf(
    GraficoData(
        titulo = "Divisão",
        texto = """
            Divisão - tira o texto?
        """.trimIndent(),
        arquivoJson = "Divisao.json"
    )
)
