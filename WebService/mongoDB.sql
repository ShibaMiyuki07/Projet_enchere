use test;

db.createCollection("counters")
db.counters.insert({id:"idimage",sequence_value:0})

function nextval(sequenceName){
    var sequenceDocument = db.counters.findAndModify({
        query:{id: sequenceName },
        update: {$inc:{sequence_value:1}},
        new:true
    })
    return sequenceDocument.sequence_value;
}

db.createCollection("image")

db.image.insert({
    "idimage": nextval("idimage"),
    "idenchere": 1,
    "image":["taxi2.jpg","taxi2.jpg"]
})