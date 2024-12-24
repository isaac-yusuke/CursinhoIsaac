package com.example.cursinhoisaac

// Classe para representar os dados dos gráficos
data class GraficoData(
    val titulo: String,
    val arquivoJson: String, // Adicionamos o nome do arquivo JSON
    val videoFileName: String // Nome do arquivo de vídeo
)

// Lista com os dados dos gráficos
val graficos = listOf(
    GraficoData(
        titulo = "Divisão",
        arquivoJson = "Divisao.json",
        videoFileName = "videoDivisao.mp4"
    )
)
