function deleteFun(url, layer, $, obj) {
    layer.confirm('真的删除行么', function(index){
        $.ajax({
            url: url,
            method: 'DELETE',
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (data.code === 200) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    layer.msg('删除成功', {icon: 1})
                } else {
                    layer.msg('删除失败', {icon: 5})
                }
            }
        })
    });
}