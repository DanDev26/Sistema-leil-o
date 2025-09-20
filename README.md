
# Leilões TDSat

Um sistema de gerenciamento de produtos para leilões, desenvolvido em **Java** utilizando **Swing** para interface gráfica e **JDBC** para conexão com banco de dados.

## 📋 Funcionalidades
- Cadastro de produtos para leilão
- Listagem de produtos cadastrados
- Conexão com banco de dados para persistência dos dados
- Interface gráfica intuitiva feita com Swing

## 🛠️ Tecnologias Utilizadas
- **Java SE 8+**
- **Swing** (Interface Gráfica)
- **JDBC** (Conexão com Banco de Dados)
- **NetBeans IDE** (Desenvolvimento)
- Banco de Dados **MySQL/MariaDB**

## 📂 Estrutura do Projeto
- `cadastroVIEW.java` / `.form` → Tela de cadastro de produtos
- `listagemVIEW.java` / `.form` → Tela de listagem dos produtos cadastrados
- `ProdutosDAO.java` → Classe DAO responsável pelo acesso aos dados
- `ProdutosDTO.java` → Classe DTO para transferência de dados
- `conectaDAO.java` → Classe para conexão com o banco de dados

## ⚙️ Pré-requisitos
Antes de executar, verifique se possui:
- Java JDK 8 ou superior
- Servidor MySQL/MariaDB rodando
- NetBeans (ou outra IDE de sua preferência)
- Driver JDBC do MySQL adicionado ao projeto

## 🚀 Como Executar
1. Clone ou baixe este repositório.
2. Importe o projeto no NetBeans.
3. Configure a classe `conectaDAO.java` com os dados corretos do seu banco:
   ```java
   String url = "jdbc:mysql://localhost:3306/leiloes";
   String user = "root";
   String password = "senha";
   ```
4. Execute o script SQL fornecido para criar o banco e tabelas.
5. Compile e execute o projeto.

## 📝 Gerar Executável (.jar)
No NetBeans:
- Vá em **Projetos > Propriedades > Build > Packaging**
- Marque a opção **Include libraries in JAR**
- Compile e gere o `.jar`

## 📄 Licença
Este projeto é para fins educacionais.
