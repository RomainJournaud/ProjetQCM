/**
 * 
 */

$('#ajoutQuestion').on('click',function(){
	var nbQuest = $("#formCreaTest").attr('data-nbQuest');
	nbQuest++;
	var html = '<fieldset class="scheduler-border">';
		html += '<div class="form-group">'
			html +=	 '<label for="question_'+nbQuest+'_enonce">Question '+nbQuest+':</label>'
			html +=  '<input type="text" class="form-control" class="question" name="question_'+nbQuest+'_enonce" id="question'+nbQuest+'_enonce">'
			html +=  '<input type="hidden" name="question_'+nbQuest+'_nbRep" id="question_'+nbQuest+'_nbRep" value="0">'
		html += '</div>';
		html += '<button type="button" class="btn btn-secondary btn-lg btn-block" class="ajoutReponse" data-numQuest="'+nbQuest+'" onclick="addReponse(this);">Ajouter une réponse</button>';
	html += '</fieldset>';
	$(this).prepend(html);
	$("#formCreaTest").attr('data-nbQuest',nbQuest);
});

function addReponse(element){
	var numQuest = $(element).attr(data_numQuest);
	var nbRep = $('#question_'+numQuest+'_nbRep').val();
	nbRep++;
	
	var html = '<div class="form-group">'
		html +=	 '<label for="reponse_'+numQuest+'_'+nbRep+'_reponse">Réponse '+nbRep+':</label>'
		html +=  '<input type="text" class="form-control" class="reponse" name="reponse_'+numQuest+'_'+nbRep+'_reponse" id="reponse_'+numQuest+'_'+nbRep+'_reponse">'
		html +=  '<label>Réponse valide :</label>';
		html +=  '<label for="reponse_'+numQuest+'_'+nbRep+'_valide_O">Oui</label><input type="checkbox" name="reponse_'+numQuest+'_'+nbRep+'_valide" value="1" id="reponse_'+numQuest+'_'+nbRep+'_valide_O">';
		html +=  '<label for="reponse_'+numQuest+'_'+nbRep+'_valide_N">Non</label><input type="checkbox" name="reponse_'+numQuest+'_'+nbRep+'_valide" value="0" id="reponse_'+numQuest+'_'+nbRep+'_valide_N">';
	html += '</div>';
	
	$(element).prepend(html);
	$('#question_'+numQuest+'_nbRep').val(nbRep);
}