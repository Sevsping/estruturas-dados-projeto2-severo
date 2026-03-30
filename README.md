# Projeto 1 - Árvores e Balanceamento
Estruturas, Pesquisa e Ordenação de Dados II
Unicesumar - Campus Ponta Grossa
2026.1 | Prof. Gabriel Passos de Jesus
Aluno: Severo Junior

Objetivo: Implementação BST, AVL, Rubro-Negra + Heurística TSP + Experimentos estatísticos.[file:1]

## Conteúdo
- [Estruturas Implementadas](#estruturas)
- [Como Executar](#executar)
- [Experimentos](#experimentos)
- [Relatório](#relatorio)

## Estruturas
| Árvore | Operações | Complexidade |
|--------|-----------|--------------|
| BST | insert, delete, search, height | O(log n) médio |
| AVL | + balanceamento rotations | O(log n) garantido |
| Rubro-Negra | + cores/black-height | O(log n) garantido |
| TSP | Nearest Neighbor heurística | Aproximada |

## Como Executar
### Pré-requisitos
- Java 17+
- Maven (opcional)

### Compilar e Rodar
```bash
git clone https://github.com/SEU-USER/estruturas-dados-ii-projeto1-severo.git
cd estruturas-dados-ii-projeto1-severo

javac -d classes src/main/java/**/*.java
java -cp classes Main trees

java -cp classes Main tsp n=100 runs=30
```

## Experimentos
- Tamanhos: 1.000, 5.000, 10.000 nós
- Runs: 30 por configuração
- Métricas: Tempo médio ± desvio padrão (ns)
- Dados: experiments/data/inputs_*.csv
- Resultados: experiments/results/times_*.csv

## Relatório
 - Introdução, Teoria, Análise O(), Metodologia, Resultados,Discussão,Conclusão.

## 🌳 ÁRVORES DE BUSCA IMPLEMENTADAS

| Árvore | Funcionalidades | Teste OnlineGDB |
|--------|-----------------|-----------------|
| **BST** | insert/search/height/delete | `Altura 3 ✓ 40:true ✓ 99:false ✓` |
| **AVL** | 4 rotações LL/RR/LR/RL | `Busca 20: true ✓ Altura 2 ✓` |
| **Rubro-Negra** | insert/fixInsert | `Busca 20: true ✓` |

