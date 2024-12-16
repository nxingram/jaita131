console.log("pagina utenti")

const form = document.querySelector("#form-aggiungi");
const formId = document.querySelector("#form-id");
const formModifica = document.querySelector("#form-modifica");



formModifica.addEventListener("submit", async function(event)
{
	event.preventDefault();
	try{
		let utenteModifica =
		{
			"id":  this.nome.id,
			"nome":  this.nome.value,
			"cognome":  this.cognome.value,
			"eta":  this.eta.value,
			"email":  this.email.value,
			"password":  this.password.value
		};
		
			let response = await fetch("/api/utente", {
				method:'PUT',
				body : JSON.stringify(utenteModifica),
				headers : {'Content-Type': 'application/json'}
			});
			
			let data = response.json();
			console.log(data)
		
	}catch(e){
		console.log(e)
	}
})


formId.addEventListener("submit", async function(event){
	event.preventDefault();
	try{	
		let id = this.idUtente.value;
		let response = await fetch("/api/utente/"+ id);
		
		let data = await response.json();
		
		formModifica.id.value = data.nome
		formModifica.nome.value = data.nome
		formModifica.cognome.value = data.cognome
		formModifica.eta.value = data.eta
		formModifica.email.value = data.email
		
	}catch(e){
		console.log(e)
	}
})



form.addEventListener("submit", async function(event){
	
	event.preventDefault();
	//fetch
	//console.log(this.nome.value);
	
	let nuovoUtente = 
	{
		"nome":  this.nome.value,
		"cognome":  this.cognome.value,
		"eta":  this.eta.value,
		"email":  this.email.value,
		"password":  this.password.value
	}
	
	try{	
	
		let response = await fetch("/api/utente", {
			method:'POST',
			body : JSON.stringify(nuovoUtente),
			headers : {'Content-Type': 'application/json'}
		});
		
		let data = await response.json();
		console.log(data);
		
	}catch(e){
		console.log(e);
	}

})

