/* Author:Moises
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

                                                                      
                                             
 
function validarForm(form){
    
    if(!form.disciplina.value){
        alert("O campo DISCIPLINA é obrigatório.");      
        return false;
    }
    if(!form.assunto.value){
        alert("O campo ASSUNTO é obrigatório.");
        return false;
    }
    
    if(!form.peso.value){
        alert("O campo PESO é obrigatório.");
        return false;
    }
    
         
    if(form.peso.value <= 0 || form.peso.value > 10){
        alert("O PESO está fora do padrão.");
        return false;
    }
    
    
    if (form.tipo[0].checked==false && form.tipo[1].checked==false) {
        alert("Selecione o tipo.");
        return false;
    }
    
    if(!form.enunciado.value){
        alert("O campo ENUNCIADO é obrigatório.");
        return false;
    }
    
    if(!form.alternativaCorreta.value){
        alert("O campo ALTERNATIVA CORRETA é obrigatório.");
        return false;
    }
    if(!form.alternativa1.value){
        alert("O campo ALTERNATIVA INCORRETA 1 é obrigatório.");
        return false;
    }
    
    if(!form.alternativa2.value){
        alert("O campo ALTERNATIVA INCORRETA 2 é obrigatório.");
        return false;
    }
    
    if(!form.alternativa3.value){
        alert("O campo ALTERNATIVA INCORRETA 3 é obrigatório.");
        return false;
    }
    
    if(!form.alternativa4.value){
        alert("O campo ALTERNATIVA INCORRETA 4 é obrigatório.");
        return false;
    }
           
    return true;
}// fim function validarForm

 
 
 
function validarLogin(form){ 
    
    //validacao de senha preenchida
    if (!form.login.value) {
        alert("Preencha o login.");
        return false;
    }  
    
     //validacao de login mais de 4 caracteres
    if (form.login.value.length <= 4) {
        alert("Preencha o login com 5 ou mais caracteres.");
        return false;
    }
    
    //validacao de senha preenchida
    if (!form.senha.value) {
        alert("Preencha a senha.");
        return false;
    }
             
    //validacao de senha mais de 5 caracteres
    if (form.senha.value.length <= 4) {
        alert("Preencha a senha com 6 ou mais caracteres.");
        return false;
    }
           
    return true;
}




 //Valida cadastro de aluno
function validaCadastroAl(form){ 
     
    //validacao de senha preenchida
    if (!form.nomeAluno.value) {
        alert("Insira o seu nome.");
        return false;
    }  
    
     //validacao de senha preenchida
    if (!form.matricula.value) {
        alert("Insira a sua matricula.");
        return false;
    }
    
     //validacao de login mais de 4 caracteres
    if (form.matricula.value.length <= 4) {
        alert("Matricula com 5 ou mais caracteres.");
        return false;
    }
    
    //validacao de senha preenchida
    if (!form.senhaAluno.value) {
        alert("Cadastre a senha.");
        return false;
    }
             
    //validacao de senha mais de 5 caracteres
    if (form.senhaAluno.value.length <= 5) {
        alert("Cadastre a senha com 6 ou mais caracteres.");
        return false;
    }
           
    return true;
} //Fim valida cadastro de aluno


//valida cadastro professor
function validaCadastroProf(form){ 
            
    //validacao de nome preenchido
    if (!form.nomeProf.value) {
        alert("Insira o seu nome.");
        return false;
    }  
    
    //validacao de disciplina
    if (!form.disciplina.value) {
        alert("Insira a sua disciplina.");
        return false;
    }  
    
     //validacao de senha preenchida
    if (!form.siape.value) {
        alert("Insira o seu SIAPE.");
        return false;
    }
    
     //validacao de login mais de 4 caracteres
    if (form.siape.value.length <= 4) {
        alert("SIAPE com 5 ou mais caracteres.");
        return false;
    }
    
    //validacao de senha preenchida
    if (!form.senhaProf.value) {
        alert("Cadastre a senha.");
        return false;
    }
             
    //validacao de senha mais de 5 caracteres
    if (form.senhaProf.value.length <= 5) {
        alert("Cadastre a senha com 6 ou mais caracteres.");
        return false;
    }
           
    return true;
}
//Fim valida cadastro professor