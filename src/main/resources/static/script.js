const api = "http://localhost/tarefas";

let tarefas = [];
let editandoTarefa;
getTarefas(render = true);

async function getTarefas(render){
    await fetch(api)
            .then(r => r.json())
            .then(r => tarefas = r)
            .catch(e => console.error(e));
    renderizarTarefas()
}

function renderizarTarefas(){
    const corpoTabela = document.getElementById("tabela-tarefas");
    corpoTabela.innerHTML = "";

    tarefas.forEach(tarefa => {
        let linha = document.createElement("tr");
        linha.innerHTML = `
            <td>${tarefa.titulo}</td>
            <td>${tarefa.descricao}</td>
            <td>
                <button class="editar" onClick="editarTarefa(${tarefa.id})">Editar</button>
                <button class="excluir" onClick="excluirTarefa(${tarefa.id})">Excluir</button>
            </td>
        `;
        corpoTabela.appendChild(linha)
    })
}

async function adicionarTarefa() {
    let titulo = document.getElementById("titulo").value;
    let descricao = document.getElementById("descricao").value;
    
    let json = {"titulo": titulo, "descricao": descricao}
  await fetch(api, {
        method:"POST",
        headers: {
            "Content-Type": "application/json"
        },
        body:JSON.stringify(json)
    }).catch(e => console.error(e))
}

async function excluirTarefa(id){
    await fetch(`${api}/${id}`, {method:"DELETE"})
    .catch(e => console.error(e));
    getTarefas(true);
}

async function atualizarTarefa(id){
    let titulo = document.getElementById("titulo").value;
    let descricao = document.getElementById("descricao").value;
    
    let json = {"titulo": titulo, "descricao": descricao}
    await fetch(`${api}/${id}`, {
        method:"PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body:JSON.stringify(json)
    }).catch(e => console.error(e))
}

function editarTarefa(id){
    editandoTarefa = id;
    let tarefa = tarefas.find(t => t.id === id);
    document.getElementById("cancel").style.display = "";

    document.getElementById("titulo").value = tarefa.titulo;
    document.getElementById("descricao").value = tarefa.descricao;
}

document.getElementById("form").addEventListener("submit", async e => {
    e.preventDefault();
    if(!editandoTarefa){
        await adicionarTarefa();
        getTarefas(render = true);
    } else {
        await atualizarTarefa(editandoTarefa);
        editandoTarefa = null;
        getTarefas(render = true);
    }
    document.getElementById("form").reset();
    document.getElementById("cancel").style.display = "none";
});

document.getElementById("cancel").addEventListener("click", e => {
    e.preventDefault();
    editandoTarefa = null;
    document.getElementById("cancel").style.display = "none";
    document.getElementById("form").reset();
})