Feature: Create Product

	@Run
	Scenario: Crear un producto y verificar que se muestra en la página de productos
	Given se ingresa en "createProduct"
	When se ingresa texto "random" en "code"
	And se ingresa texto "Descripción de prueba" en "description"
	And click en "factory"
	And click en "remera"
	And click en "submit"
	And se ingresa en "getProducts"
	Then se verifica texto "random" en "productsTable"