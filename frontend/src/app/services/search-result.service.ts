import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SearchResult } from '../model/search-result';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
@Injectable({providedIn: "root"})
export class SearchResultService {

  private http = inject(HttpClient);
  private api = "http://localhost:8080/search";
  constructor() { 
  }

  public searchBooks(query: string, page: number): Observable<SearchResult> {
    return this.http.get<SearchResult>(this.api, {
      params: new HttpParams().append("q", query).append("page", page)
    });
  }

}
