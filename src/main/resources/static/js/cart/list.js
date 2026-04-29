const select = document.getElementById('select')
// const select2 = document.getElementsByClassName('select2')
// const del = document.getElementsByClassName('del')
const btn2 = document.getElementById('btn2')
const list = document.getElementById('list')

getList()

function getList() {
    fetch("./cartlist")
        .then(r => r.text())
        .then(r => {
            r = r.trim()
            list.innerHTML = r
        })
}

list.addEventListener('click', (e) => {
    if (e.target.classList.contains('del')) {
        let pn = e.target.previousElementSibling.getAttribute("data-id")
        let p = new URLSearchParams();
        p.append("productNo", pn)

        fetch("./delete", {
            method: "POST",
            body: p
        })
            .then(r => r.text())
            .then(r => {
                r = r.trim()
                if (r > 0) {
                    getList()
                } else {
                    alert('삭제 실패')
                }
            })
    }

    if(e.target.classList.contains('select2')){
        let select2 = document.querySelectorAll('.select2')
        let r = true
        for(c of select2) {
            if(!c.checked){
                r=false
            }
        }
        select.checked = r
    }
})

select.addEventListener('click', () => {
    let select2 = document.querySelectorAll('.select2')
    for (let x of select2) {
        x.checked = select.checked
    }
})

// for (let x of select2) {
//     x.addEventListener('click', () => {
//         let flag = true

//         for (let y of select2) {
//             if (!y.checked) {
//                 flag = false
//                 break
//             }
//         }
//         select.checked = flag
//     })
// }

// for (let d of del) {
//     d.addEventListener("click", () => {
//         let pn = d.previousElementSibling.getAttribute("data-id")
//         let p = new URLSearchParams();
//         p.append("productNo", pn)

//         fetch("./delete", {
//             method: "POST",
//             body: p
//         })
//             .then(r => r.text())
//             .then(r => {
//                 r = r.trim()
//                 if (r > 0) {
//                     getList()
//                 } else {
//                     alert('삭제 실패')
//                 }
//             })
//     })
// }

btn2.addEventListener("click", () => {
    let pn = new URLSearchParams()
    let select2 = document.querySelectorAll('.select2')
    for (let c of select2) {
        if (c.checked) {
            pn.append('productNo', c.getAttribute('data-id'))
        }
    }

    fetch("./delete", {
        method: "POST",
        body: pn
    })
        .then(res => res.text())
        .then(res => {
            res = res.trim()

            if (res > 0) {
                const checkedList = document.querySelectorAll(".select2:checked")

                checkedList.forEach(c => {
                    c.closest("tr").remove()
                })
            }
        })
})