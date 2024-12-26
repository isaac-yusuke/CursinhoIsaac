package com.example.cursinhoisaac

// Classe para representar os dados dos gráficos
data class GraficoData(
    val titulo: String,
    val arquivoJson: String, // Adicionamos o nome do arquivo JSON
    val videoUrl: String // Adicionado para armazenar o link do vídeo
)

// Lista com os dados dos gráficos
val graficos = listOf(
    GraficoData(
        titulo = "Multiplicação",
        arquivoJson = "Multiplicacao.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    ),GraficoData(
        titulo = "Divisão",
        arquivoJson = "Divisao.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    ),GraficoData(
        titulo = "Frações",
        arquivoJson = "Fracoes.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    ),GraficoData(
        titulo = "Funções",
        arquivoJson = "Funcoes.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    ),GraficoData(
        titulo = "Gráficos",
        arquivoJson = "Graficos.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    ),GraficoData(
        titulo = "Equações",
        arquivoJson = "Equacoes.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    )
)
