// 使用 Fetch API 接收并下载文件
function download() {
    fetch('url', {
        headers: {'Content-Type': 'application/json;charset=UTF-8'},
        method: 'POST',
        body: JSON.stringify('要传给后端的参数')
    }).then(res => {
        return res.blob()
    }).then(blob => {
        let a = document.createElement('a')
        a.href = URL.createObjectURL(blob)
        a.download = "demo.zip"
        a.style.display = 'none'
        document.body.append(a)
        a.click()
        URL.revokeObjectURL(a.href)
        a.remove()
    }).catch(err => {
        console.log(err)
    })
}