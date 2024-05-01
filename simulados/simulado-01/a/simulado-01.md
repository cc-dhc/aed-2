# Simulado 01

1. Assinale das seguintes afirmações sobre o crescimento assintótico das funções marque V para verdadeira e F  para falso (4pts):
	- **V**
	- **V**
	- **V**
	- **F**: Se f(n) = O(g(n)),então g(n) = O(f(n));
	- f(n) = n g(n) = n^2;
	- se f(n) = O(g(n)) = O(n^2), entao g(n) = O(f(n)) = O(n)
	- **V**
	- **V**
2. Sejam duas funções f(n) e g(n) que mapeiam números inteiros positivos em números reais positivos. Com respeito às notações assintóticas de complexidade, marque V para verdadeiro e F para Falso.
	- **V**
	- **V**
	- **V**
	- **V**
	- **V**
3. Cite os 3 princípios paradigmas de proteção (Princípios de McConnell¹).
	Para resolver o paradigma anterior - *garbage in, garbage out* - foram criados três outros paradigmas voltados a programação defensiva:
	- *garbage in, nothing out*
	- *garbage in, error message out*
	- *no garbage allowed in*
4. Quais são os 4 passos que devem ser compreendidos para lançar uma exceção, descreva suscintamente cada um deles. 
	1. Como criar sua própria exceção?
		Devo criar uma *classe* que estenda a *classe* **Exception** 
	2. Como lançar uma exceção?
		Devo dar *throw* em uma instância *classe* criada.
	3. Como propagar uma exceção?
		O *método* que lança a *exceção* deve conter o *tipo* da *exceção* em sua *assinatura*.
	4. Como capturar e tratar uma exceção?
		Deve ser usado a diretiva **try-catch**, junto com **finally** quando necessário.
5. Encontre a ordem de complexidade do custo das atribuições dos seguintes trechos de código:
	- $O(n^2)$, $\Omega(n^2)$, $\Theta(n^2)$
	- $O(n^2)$, $\Omega(n^2)$, $\Theta(n^2)$
	- $O(n^2)$, $\Omega(n^2)$, $\Theta(n^2)$
	- $O(n^2)$, $\Omega(n^2)$, $\Theta(n^2)$
