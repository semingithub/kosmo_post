const select = document.getElementById('select')
const select2 = document.getElementsByClassName('select2')

select.addEventListener('click', () => {
    for (let x of select2) {
        x.checked = select.checked
    }
})

for (let x of select2) {
    x.addEventListener('click', () => {
        let flag = true

        for (let y of select2) {
            if (!y.checked) {
                flag = false
                break
            }
        }
        select.checked = flag
    })
}