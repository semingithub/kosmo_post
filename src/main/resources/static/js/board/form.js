const add = document.getElementById('add')
const result = document.getElementById('result')
const create = document.getElementById('create')

let no = result.getAttribute("data-file-size")

add.addEventListener('click', function() {


    if (no > 4) {
        alert('최대 5개까지 생성가능합니다.')
		return
    } else {

        let d = document.createElement('div')
        d.id = `id${no}`
		
        let i = document.createElement('input')
        i.type = 'file'
        i.name = 'attach'
        i.classList.add('form-control')

        let b = document.createElement('button')
        b.type = 'button'
        b.innerText = '삭제'
        b.setAttribute('data-id', `id${no}`)
        b.classList.add('btn')

        d.append(i)
        d.append(b)

        result.append(d)

        no++
    }
})


result.addEventListener('click', function(e) {
    if (e.target.classList.contains('btn')) {
        let rm = e.target.getAttribute('data-id')
        document.getElementById(rm).remove()
        no--
    }
})

/*create.addEventListener('click', () => {
    let form = new FormData()
    form.append('boardTitle', 'ajax title')
    form.append('boardWriter', 'ajax Writer')
    form.append('boardContents', 'ajax Contents')

    fetch('./create', {
        method: 'post',
        body: form
    })
        .then(res => res.text())
        .then(res => console.log(res))
})*/
