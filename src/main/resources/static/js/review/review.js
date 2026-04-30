const list = document.getElementById("review_list")
const review = document.getElementById("review_write")
const dBtn = document.getElementsByClassName("dBtn")
const uBtn = document.getElementsByClassName("uBtn")
const uBtn_update = document.getElementById("uBtn_update")

const productNo = list.dataset.id

reloadReview()

function reloadReview() {
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
                contents.value = ""
                reloadReview()
            })
    })
}

// 수정, 삭제
list.addEventListener("click", (e) => {
    if (e.target.classList.contains("dBtn")) {
        const reviewNo = e.target.parentElement.dataset.id

        const formData = new FormData()
        formData.append("reviewNo", reviewNo)

        fetch("/review/delete", {
            method: "POST",
            body: formData
        })
            .then(res => res.text())
            .then(res => {
                if (res > 0) {
                    alert("삭제되었습니다")
                    reloadReview()
                } else {
                    alert("실패")
                }
            })
    }
    if (e.target.classList.contains("uBtn")) {
        const reviewContents = e.target.parentElement.parentElement.firstElementChild.innerText
        document.getElementById("uContents").innerText = reviewContents

        const reviewNo = e.target.parentElement.dataset.id
        document.getElementById("uBtn_update").dataset.id = reviewNo

        const reviewStar = e.target.parentElement.dataset.star
        document.getElementById("uStar").value = reviewStar
    }
})

// 수정 폼
uBtn_update.addEventListener("click", () => {

    const reviewNo = uBtn_update.dataset.id
    const contents = document.getElementById("uContents").value
    const star = document.getElementById("uStar").value

    if (!contents.trim()) {
        alert("내용 입력하세요")
        return
    }
    const formData = new FormData()
    formData.append("reviewNo", reviewNo)
    formData.append("reviewContents", contents)
    formData.append("reviewStar", star)

    fetch("/review/update", {
        method: "POST",
        body: formData
    })
        .then(res => res.text())
        .then(res => {
            res = res.trim()
            if (res > 0) {
                alert("수정 완료")
               	$('#reviewModal').modal('hide')
                reloadReview()
            } else {
                alert("수정 실패")
            }
        })
})