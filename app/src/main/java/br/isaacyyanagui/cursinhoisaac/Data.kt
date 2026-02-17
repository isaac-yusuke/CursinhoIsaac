package br.isaacyyanagui.cursinhoisaac

// Classe para representar os dados dos gráficos
data class GraficoData(
    val titulo: String,
    val arquivoJson: String, // Nome do arquivo JSON com estado do gráfico
    val videoUrl: String, // Mantido para uso futuro
    val texto: String, // Texto exibido na lateral direita da tela do gráfico
    val listaParametros: List<String> // Rótulos dos parâmetros numéricos (num1, num2, ...)
)

// Lista com os dados dos gráficos
val graficos = listOf(
    GraficoData(
        titulo = "Soma e Subtração",
        arquivoJson = "SomaESubtracao.json",
        videoUrl = "https://www.youtube.com/watch?v=C8WqYKAm1ac",
        texto = "Soma e Subtração\n\nDigite o valor dos números para calcular a soma ou subtração.",
        listaParametros = listOf("Número 1", "Número 2")
    ),
    GraficoData(
        titulo = "Multiplicação",
        arquivoJson = "Multiplicacao.json",
        videoUrl = "https://www.youtube.com/watch?v=4vgctY4r_eQ",
        texto = "Multiplicação\n\nDigite o valor dos números para calcular a multiplicação.",
        listaParametros = listOf("Número 1", "Número 2")
    ),
    GraficoData(
        titulo = "Divisão",
        arquivoJson = "Divisao.json",
        videoUrl = "https://www.youtube.com/watch?v=aI4Y9753k9s",
        texto = "Divisão\n\nDigite o valor dos números para calcular a divisão.",
        listaParametros = listOf("Dividendo", "Divisor")
    ),
    GraficoData(
        titulo = "Frações",
        arquivoJson = "Fracoes.json",
        videoUrl = "https://www.youtube.com/watch?v=HfnM1_b0OxE",
        texto = "Frações\n\nDigite o valor do numerador e denominador das frações.",
        listaParametros = listOf("Numerador 1", "Denominador 1", "Numerador 2", "Denominador 2")
    ),
    GraficoData(
        titulo = "Números Decimais",
        arquivoJson = "NumerosDecimais.json",
        videoUrl = "https://www.youtube.com/watch?v=5oBuMWMWbw4",
        texto = "Números Decimais\n\nDigite o valor dos números para calcular.",
        listaParametros = listOf("Número 1", "Número 2")
    ),
    GraficoData(
        titulo = "Regra de 3",
        arquivoJson = "RegraDe3.json",
        videoUrl = "https://www.youtube.com/watch?v=9-lvGVBR3WA",
        texto = "Regra de 3\n\nDigite o valor dos números para a regra de 3.",
        listaParametros = listOf("Número 1", "Número 2", "Número 3")
    ),
    /*GraficoData(
        titulo = "Funções",
        arquivoJson = "Funcoes.json",
        videoUrl = "https://www.youtube.com/watch?v=m1VcsycXkwM",
        texto = "Funções\n\nDigite os coeficientes para calcular.",
        listaParametros = listOf("a", "b")
    ),*/
    GraficoData(
        titulo = "Plano Cartesiano",
        arquivoJson = "Graficos.json",
        videoUrl = "https://www.youtube.com/watch?v=pQ5fXG69J8c",
        texto = "Plano Cartesiano\n\nDigite as coordenadas para visualizar no gráfico.",
        listaParametros = listOf("x", "y")
    ),
    GraficoData(
        titulo = "Porcentagem",
        arquivoJson = "Porcentagem.json",
        videoUrl = "https://www.youtube.com/watch?v=cxZtKM7R9TQ",
        texto = "Porcentagem\n\nDigite os valores para calcular a porcentagem.",
        listaParametros = listOf("Total", "Porcentagem %")
    ),
    /*GraficoData(
        titulo = "Equações",
        arquivoJson = "Equacoes.json",
        videoUrl = "https://www.youtube.com/watch?v=DyxvxXGXB6c",
        texto = "Equações\n\nDigite os coeficientes da equação.",
        listaParametros = listOf("a", "b", "c")
    ),*/
    GraficoData(
        titulo = "Potência",
        arquivoJson = "Potencia.json",
        videoUrl = "https://www.youtube.com/watch?v=RzCwiKZJo6o",
        texto = "Potência e Raiz Quadrada\n\nDigite os valores para calcular a potência",
        listaParametros = listOf("Base", "Expoente")
    ),
    GraficoData(
        titulo = "Notação Científica",
        arquivoJson = "NotacaoCientifica.json",
        videoUrl = "https://www.youtube.com/watch?v=MSgnl_S1PHc",
        texto = "Notação Científica\n\nDigite até 2 números para calcular a notação científica.",
        listaParametros = listOf("a", "b")
    ),
    GraficoData(
        titulo = "Fórmula de Bhaskara",
        arquivoJson = "Bhaskara.json",
        videoUrl = "https://www.youtube.com/watch?v=u2D-pgco1h0",
        texto = "Fórmula de Bhaskara\n\nDigite os coeficientes da equação do 2º grau.\nax²+bx+c=0",
        listaParametros = listOf("a", "b", "c")
    )
)
