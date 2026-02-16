package br.isaacyyanagui.cursinhoisaac

// Classe para representar os dados dos gráficos
data class GraficoData(
    val titulo: String,
    val arquivoJson: String, // Adicionamos o nome do arquivo JSON
    val videoUrl: String, // Adicionado para armazenar o link do vídeo
    val texto: String // Texto exibido na lateral direita da tela do gráfico
)

// Lista com os dados dos gráficos
val graficos = listOf(
    GraficoData(
        titulo = "Soma e Subtração",
        arquivoJson = "SomaESubtracao.json",
        videoUrl = "https://www.youtube.com/watch?v=C8WqYKAm1ac",
        texto = "Soma e Subtração\n\nUse os controles do gráfico para alterar os números e observar o resultado."
    ),
    GraficoData(
        titulo = "Multiplicação",
        arquivoJson = "Multiplicacao.json",
        videoUrl = "https://www.youtube.com/watch?v=4vgctY4r_eQ",
        texto = "Multiplicação\n\nExplore a ferramenta para visualizar o produto entre diferentes valores."
    ), GraficoData(
        titulo = "Divisão",
        arquivoJson = "Divisao.json",
        videoUrl = "https://www.youtube.com/watch?v=aI4Y9753k9s",
        texto = "Divisão\n\nAjuste os números para praticar divisão e interpretação do quociente."
    ), GraficoData(
        titulo = "Frações",
        arquivoJson = "Fracoes.json",
        videoUrl = "https://www.youtube.com/watch?v=HfnM1_b0OxE",
        texto = "Frações\n\nModifique numerador e denominador para entender equivalência e simplificação."
    ), GraficoData(
        titulo = "Números Decimais",
        arquivoJson = "NumerosDecimais.json",
        videoUrl = "https://www.youtube.com/watch?v=5oBuMWMWbw4",
        texto = "Números Decimais\n\nTeste diferentes valores para reforçar leitura e operações com decimais."
    ), GraficoData(
        titulo = "Regra de 3",
        arquivoJson = "RegraDe3.json",
        videoUrl = "https://www.youtube.com/watch?v=9-lvGVBR3WA",
        texto = "Regra de 3\n\nExperimente proporções para identificar relações diretas e inversas."
    ), GraficoData(
        titulo = "Funções",
        arquivoJson = "Funcoes.json",
        videoUrl = "https://www.youtube.com/watch?v=m1VcsycXkwM",
        texto = "Funções\n\nAltere parâmetros para perceber como o gráfico da função se transforma."
    ), GraficoData(
        titulo = "Plano Cartesiano",
        arquivoJson = "Graficos.json",
        videoUrl = "https://www.youtube.com/watch?v=pQ5fXG69J8c",
        texto = "Plano Cartesiano\n\nObserve pontos e coordenadas para fortalecer noções de localização no plano."
    ), GraficoData(
        titulo = "Porcentagem",
        arquivoJson = "Porcentagem.json",
        videoUrl = "https://www.youtube.com/watch?v=cxZtKM7R9TQ",
        texto = "Porcentagem\n\nCompare percentuais em diferentes contextos e veja os resultados instantaneamente."
    ), GraficoData(
        titulo = "Equações",
        arquivoJson = "Equacoes.json",
        videoUrl = "https://www.youtube.com/watch?v=DyxvxXGXB6c",
        texto = "Equações\n\nAjuste os termos para praticar resolução e interpretação de incógnitas."
    ), GraficoData(
        titulo = "Potência e Raíz Quadrada",
        arquivoJson = "Potencia.json",
        videoUrl = "https://www.youtube.com/watch?v=RzCwiKZJo6o",
        texto = "Potência e Raiz Quadrada\n\nExperimente expoentes e raízes para visualizar os efeitos em cada operação."
    ), GraficoData(
        titulo = "Notação Científica",
        arquivoJson = "NotacaoCientifica.json",
        videoUrl = "https://www.youtube.com/watch?v=MSgnl_S1PHc",
        texto = "Notação Científica\n\nPratique conversões entre forma decimal e notação científica."
    ), GraficoData(
        titulo = "Fórmula de Bhaskara",
        arquivoJson = "Bhaskara.json",
        videoUrl = "https://www.youtube.com/watch?v=u2D-pgco1h0",
        texto = "Fórmula de Bhaskara\n\nAltere coeficientes para analisar o discriminante e as raízes da equação."
    )
)
