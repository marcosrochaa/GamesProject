package br.com.marc.games_project.model

data class InfoGame  (val info: InfoApiShark){
    override fun toString(): String {
        return info.toString()
    }
}