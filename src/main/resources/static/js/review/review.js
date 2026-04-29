const list = document.getElementById("list")
const review = document.getElementById("review_write")

const productNo = list.dataset.id

Review()

function Review() {
    fetch(`/review/list?productNo=${productNo}`)
        .then(res => res.text())
        .then(res => {
            list.innerHTML = res
        })
}



if (review) {
    const productNo = review.dataset.id
    const btn = document.getElementById("reviewBtn")
    const contents = document.getElementById("reviewContents")
    const star = document.getElementById("reviewStar")
    const list = document.getElementById("list")

    btn.addEventListener("click", () => {

        if (!contents.value.trim()) {
            alert("내용 입력하세요")
            return
        }

        const formData = new FormData()
        formData.append("productNo", productNo)
        formData.append("reviewContents", contents.value)
        formData.append("reviewStar", star.value)

        fetch("/review/add", {
            method: "POST",
            body: formData
        })
            .then(res => res.text())
            .then(res => {
                alert("등록되었습니다")
                list.innerHTML = res

                contents.value = ""
                star.value = 5
            })
    })
}