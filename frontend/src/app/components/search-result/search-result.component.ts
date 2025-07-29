import { Component, inject, Injectable } from '@angular/core';
import { SearchResultService } from '../../services/search-result.service';
import { Observable } from 'rxjs';
import { SearchResult } from '../../model/search-result';
import { AsyncPipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-result',
  imports: [AsyncPipe],
  templateUrl: './search-result.component.html',
  styleUrl: './search-result.component.css'
})

@Injectable({providedIn: "root"})
export class SearchResultComponent {

  private searchResultService = inject(SearchResultService);
  public searchResult$ = new Observable<SearchResult>;
  private route = inject(ActivatedRoute);

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.searchResult$ = this.searchResultService.searchBooks(params["q"]);
    })
  }
}
