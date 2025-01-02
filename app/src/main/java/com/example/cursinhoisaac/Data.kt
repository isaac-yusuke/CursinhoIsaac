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
        titulo = "Soma e Subtração",
        arquivoJson = "SomaESubtracao.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),
    GraficoData(
        titulo = "Multiplicação",
        arquivoJson = "Multiplicacao.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Divisão",
        arquivoJson = "Divisao.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Frações",
        arquivoJson = "Fracoes.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Números Decimais",
        arquivoJson = "NumerosDecimais.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Funções",
        arquivoJson = "Funcoes.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Plano Cartesiano",
        arquivoJson = "Graficos.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Equações",
        arquivoJson = "Equacoes.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Potência e Raíz Quadrada",
        arquivoJson = "Potencia.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    ),GraficoData(
        titulo = "Fórmula de Bhaskara",
        arquivoJson = "Bhaskara.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ" //Never Gonna give you up
    )
)
