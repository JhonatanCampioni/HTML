function limpar(){
    document.getElementById('display').value = '';
}

function add_display(num){
    document.getElementById('display').value += num;
}

function calcular(){
    document.getElementById('display').value = eval(document.getElementById('display').value);
}