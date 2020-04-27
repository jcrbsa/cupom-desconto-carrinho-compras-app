API ResFTUL Java para Aplicação de Cupom Desconto em Carrinho de Compras
============================

![](media/plataforma_target.png)

**Sobre**


API ResFTUL Java  para o controle de carrinho de compras de um varajista brasileiro

**Descrição do Requisitos**

-	Desconto Não Progressivo:
-   Comprando 10 ou mais produtos do mesmo tipo, cada item recebe um desconto 10%

-   Desconto Progressivo:
-   A partir de 1.000,0  em compras é aplciado um desconto de 5% no valor total;
-   A partir de 5.000,0  em compras é aplciado um desconto de 7% no valor total;
-   A partir de 10.000,0  em compras é aplciado um desconto de 10% no valor total.

-   Esses cupons variação de acord com a ocasião e são aplicados de maneira glboa ao valor do carrinho

-   Os cupons de desconto nunca são cumulativos (Desconto Progressivo)

-   Caso aplicação de mais de um cupom o maior deve ser levado em consideração (Desconto Progressivo e Desconto Não Progressivo)

-   Aplicação deve permitir o cadastro de produtos e cupons

-   Inserção desses produto no carrinhos e compras

-   O carrinho deve calcular o total e subtotal dos itens

Funcionalidades 
=============================

As seguintes funcionalidades nas entidades forma implementadas:

Produto
-------

-   Criação

-   Alteração

-   Exclução

-   Consulta

Cupom Progressivo
-------

-   Criação

-   Alteração

-   Exclução

-   Consulta


Cupom Não Progressivo
-------

-   Criação

-   Alteração

-   Exclução

-   Consulta


Desconto Carrinho
-------

-   Criação

-   Consulta



Dependências
==================================



-   maven 3.6


-   spring-boot-starter-test

-   spring-boot-starter-web

-   junit-vintage-engine

-   spring-boot-starter-data-jpa

-	mysql-connector-java

-	spring-boot-devtools


# Component's Rest API Endpoints


## Endpoint Carrinho

### Todos Carrinhos

* **URL**: `/carrinhos`
* **Method:** `GET`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
  
### Adicionar Produto
  

* **URL**: `desconto`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
  
        "produto": [
            {
                "id": "1",
                "nome": "produtoA",
                "preco": "99.99",
                "tipo": "A"
            },
            {
                "id": "2",
                "nome": "produtoB",
                "preco": "66.99",
                "tipo": "B"
            },
            {
                "id": "3",
                "nome": "produtC",
                "preco": "33.99",
                "tipo": "C"
            },
            {
                "id": "4",
                "nome": "produtD",
                "preco": "11.99",
                "tipo": "A"
            },
            {
                "id": "5",
                "nome": "produtE",
                "preco": "3.99",
                "tipo": "B"
            },
            {
                "id": "6",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "7",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "9",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "10",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "11",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "12",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "13",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "14",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            },
            {
                "id": "15",
                "nome": "produtF",
                "preco": "0.99",
                "tipo": "C"
            }
            
        ],
        "cupom": [
            {
                "nome": "#MilValorCincoDesc"
            },
            {
                "nome": "#CincoMilValorSetDesc"
            },
            {
                "nome": "#DezMilValorDezDesc"
            },
            {
                "nome": "#DezQuantDezDesc"
            }
        ]
}
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
  
  
  

## Endpoint Produto

### Todos Produtos

* **URL**: `/produtos`
* **Method:** `GET`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Busca Produto

* **URL**: `/produto/buscar/{produtoId}`
* **Method:** `GET`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Adicionar Produto
  

* **URL**: `produto/adicionar`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "nome": "produtoA",
		"preco": "99.99",
		"tipo": "A"
	  }
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
  
### Alterar Produto
  

* **URL**: `produto/atualizar/{produtoId}`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
		"nome": "produtoA",
		"preco": "99.99",
		"tipo": "A"
	  }
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Excluir Produto
  

* **URL**: `produto/excluir/{produtoId}`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "nome": "produtoA",
		"preco": "99.99",
		"tipo": "A"
	  }
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
  
  
  

  
## Endpoint cupom_nao_progressivo

### Todos Cupons Nao Progressivos

* **URL**: `/cupom_nao_progressivos`
* **Method:** `GET`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Busca Cupom

* **URL**: `/cupom_nao_progressivo/buscar/{cupom_nao_progressivoId}`
* **Method:** `GET`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Adicionar Cupom
  

* **URL**: `cupom_nao_progressivo/adicionar`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	    "nome": "#DezQuantDezDesc",
		"quantidade": "10",
		"desconto": "10"
	  }
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
  
### Alterar Cupom
  

* **URL**: `cupom_nao_progressivo/atualizar/{cupom_nao_progressivoId}`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
		"nome": "#VinteQuantVinteDesc",
		"quantidade": "20",
		"desconto": "20"
	  }
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Excluir Cupom
  

* **URL**: `cupom_nao_progressivo/excluir/{cupom_nao_progressivoId}`
* **Method:** `POST`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
  
  
  
  
## Endpoint cupom_progressivo

### Todos Cupons  Progressivos

* **URL**: `/cupom_progressivo`
* **Method:** `GET`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Busca Cupom

* **URL**: `/cupom_progressivo/buscar/{cupom_progressivoId}`
* **Method:** `GET`

* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Adicionar Cupom
  

* **URL**: `cupom_progressivo/adicionar`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	    "nome": "#DezMilValorDezDesc",
		"valorcompras": "10000",
		"desconto": "10"
	  }
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
  
### Alterar Cupom
  

* **URL**: `cupom_progressivo/atualizar/{cupom_progressivoId}`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
		"nome": "#CincoMilValorSetDesc",
		"valorcompras": "5000",
		"desconto": "7"
	  }
	  ```
* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />
  
### Excluir Cupom
  

* **URL**: `cupom_progressivo/excluir/{cupom_progressivoId}`
* **Method:** `POST`


* **Success Response:**
  * **Code:** `202` <br />
		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` <br />


Copyright Facilit

![](media/logo_facilit.png)
