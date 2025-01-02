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
        videoUrl = "https://www.youtube.com/watch?v=C8WqYKAm1ac"
    ),
    GraficoData(
        titulo = "Multiplicação",
        arquivoJson = "Multiplicacao.json",
        videoUrl = "https://www.youtube.com/watch?v=4vgctY4r_eQ"
    ),GraficoData(
        titulo = "Divisão",
        arquivoJson = "Divisao.json",
        videoUrl = "https://www.youtube.com/watch?v=aI4Y9753k9s"
    ),GraficoData(
        titulo = "Frações",
        arquivoJson = "Fracoes.json",
        videoUrl = "https://www.youtube.com/watch?v=HfnM1_b0OxE"
    ),GraficoData(
        titulo = "Números Decimais",
        arquivoJson = "NumerosDecimais.json",
        videoUrl = "https://www.youtube.com/watch?v=5oBuMWMWbw4"
    ),GraficoData(
        titulo = "Funções",
        arquivoJson = "Funcoes.json",
        videoUrl = "https://www.youtube.com/watch?v=m1VcsycXkwM"
    ),GraficoData(
        titulo = "Plano Cartesiano",
        arquivoJson = "Graficos.json",
        videoUrl = "https://www.youtube.com/watch?v=pQ5fXG69J8c"
    ),GraficoData(
        titulo = "Equações",
        arquivoJson = "Equacoes.json",
        videoUrl = "https://www.youtube.com/watch?v=DyxvxXGXB6c"
    ),GraficoData(
        titulo = "Potência e Raíz Quadrada",
        arquivoJson = "Potencia.json",
        videoUrl = "https://www.youtube.com/watch?v=RzCwiKZJo6o"
    ),GraficoData(
        titulo = "Fórmula de Bhaskara",
        arquivoJson = "Bhaskara.json",
        videoUrl = "https://www.youtube.com/watch?v=u2D-pgco1h0"
    )
)
