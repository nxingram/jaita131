console.log("pagina utenti")

const form = document.querySelector("#form-aggiungi");
const formId = document.querySelector("#form-id");
const formModifica = document.querySelector("#form-modifica");
const formdelete = document.querySelector("#form-delete");


//DELETE
formdelete.addEventListener("submit", async function(event){
	event.preventDefault();
	try{
		
		let id = this.idUtente.value;
		let response = await fetch("/api/utente/"+ id,{
			method:'DELETE',
		});
		
		let data = await response.text();
		console.log(data);
		
	}catch(e){
		console.log(e);
	}
});

//PUT
formModifica.addEventListener("submit", async function(event)
{
	event.preventDefault();
	try{
		let utenteModifica =
		 JSON.stringify({
			"id":  this.idUtente.value,
			"nome":  this.nome.value,
			"cognome":  this.cognome.value,
			"eta":  this.eta.value,
			"email":  this.email.value
		});
		
			let response = await fetch("/api/utente", {
				method:'PUT',
				body : utenteModifica,
				headers : {'Content-Type': 'application/json'}
			});
			
			if(response.status == 200){
			let data = await response.json();
			console.log(data)
				
			}else{
				let data = await response.text();
				console.log(data)
			}
		
	}catch(e){
		console.log(e)
	}
})

//GET by id
formId.addEventListener("submit", async function(event){
	event.preventDefault();
	try{	
		let id = this.idUtente.value;
		let response = await fetch("/api/utente/"+ id);
		
		let data = await response.json();
		
		formModifica.idUtente.value = data.id
		formModifica.nome.value = data.nome
		formModifica.cognome.value = data.cognome
		formModifica.eta.value = data.eta
		formModifica.email.value = data.email
		
	}catch(e){
		console.log(e)
	}
})


//POST
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

