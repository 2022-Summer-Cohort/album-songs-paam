export default function albumView(album) {
    return `
        <main class="main-content">
            <section class="album-library">
                <header class="album-library-header">
                    <h2 class="album-library-header-???">${album.title}</h2>
                    <h3 class="album-library-header-???">${album.recordLabel}</h3>
                </header>    
                <section class="album-songs">
                    ${album.songs.map(song => {
        return `
                                <div class="song">
                                    <h3 class="song-title">${song.title}</h3>
                                    <input type="hidden" class="id_field" value="${song.id}">
                                    <input type="hidden" class="sum_field" value="${song.summary}">
                                    <button class="delete-button">Delete</button>
                                    <button class="edit-button">Edit</button>
                                    <input type="text" class="update-songName" placeholder="New Song Name">                

                                    </div>    
                            `
    }).join("")
        }
                </section>

                <section class="album-comments">
                ${album.comments.map(comment => {
            return `
                            <div class="comment">
                                <h3 class="userName">${comment.userName}</h3>         
                                <h3 class="commentVals">${comment.comment}</h3>         
                                </div>    
                        `
        }).join("")
        }
                </section>


                <div class="NewSongDiv">
                    <input type="text" placeholder="Song Name" class="songNameInput" \>
                    <input type="text" placeholder="Song Description" class="songDescriptionInput" \>

                    <button class="addSongButton">Add Song</button>
                </div>

                <div class="addComment">
                <input type="text" placeholder="User Name" class="userNameInput" \>
                <input type="text" placeholder="Comment" class="commentInput" \>

                <button class="addCommentButton">Add Comment</button>
                </div>

                <a class="back-navigation">back to album listings</a>
            </section>
        </main>            
    `
}